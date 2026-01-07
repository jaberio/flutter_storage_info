import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_storage_info/flutter_storage_info.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_storage_info');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(channel, (MethodCall methodCall) async {
      switch (methodCall.method) {
        case 'getStorageFreeSpace':
          return 1024 * 1024 * 500; // 500 MB
        case 'getStorageTotalSpace':
          return 1024 * 1024 * 1024; // 1 GB
        case 'getStorageUsedSpace':
          return 1024 * 1024 * 524; // 524 MB
        case 'getStorageTotalSpaceInGB':
          return 1.0;
        case 'getStorageUsedSpaceInGB':
          return 0.524;
        default:
          return null;
      }
    });
  });

  tearDown(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(channel, null);
  });

  test('getStorageFreeSpace', () async {
    expect(await FlutterStorageInfo.storageFreeSpace, 1024 * 1024 * 500);
  });

  test('getStorageTotalSpace', () async {
    expect(await FlutterStorageInfo.storageTotalSpace, 1024 * 1024 * 1024);
  });

  test('isLowOnStorage internal', () async {
    // 0.524 / 1.0 = 0.524 < 0.9 (threshold) => false
    expect(await FlutterStorageInfo.isLowOnStorage(DeviceStorageType.internal, threshold: 0.9), false);
    
    // 0.524 / 1.0 = 0.524 >= 0.5 (threshold) => true
    expect(await FlutterStorageInfo.isLowOnStorage(DeviceStorageType.internal, threshold: 0.5), true);
  });
}
