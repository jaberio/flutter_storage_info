### Version 1.0.0 - 2026-01-08

#### Changed
- **Branding**: Refactored package name and Android namespace to `com.jaberio.flutter_storage_info`.
- **Standardization**: Cleaned repository of build artifacts and IDE files.
- **Code Quality**: Applied `dart format`, resolved all linter warnings using `flutter_lints`, and added `analysis_options.yaml`.
- **Android**: Improved safety checks for external storage detection.

#### Added
- **Tests**: Introduced a unit test suite for the plugin.

---

### Initial Release (Version 0.0.1)

- **Methods:**
    - **Internal Storage:**
        - `getFreeDiskSpace`: Returns the amount of free space available on the device's internal storage.
        - `getTotalDiskSpace`: Returns the total amount of space available on the device's internal storage.
        - `getUsedDiskSpace`: Returns the amount of used space on the device's internal storage.
        - `getFreeDiskSpaceInGB`: Returns the amount of free space available on the device's internal storage in gigabytes.
        - `getTotalDiskSpaceInGB`: Returns the total amount of space available on the device's internal storage in gigabytes.
        - `getUsedDiskSpaceInGB`: Returns the amount of used space on the device's internal storage in gigabytes.
        - `getFreeDiskSpaceInMB`: Returns the amount of free space available on the device's internal storage in megabytes.
        - `getTotalDiskSpaceInMB`: Returns the total amount of space available on the device's internal storage in megabytes.
        - `getUsedDiskSpaceInMB`: Returns the amount of used space on the device's internal storage in megabytes.
    - **External Storage:**
        - `getFreeExternalDiskSpace`: Returns the amount of free space available on the device's external storage.
        - `getTotalExternalDiskSpace`: Returns the total amount of space available on the device's external storage.
        - `getUsedExternalDiskSpace`: Returns the amount of used space on the device's external storage.
        - `getFreeExternalDiskSpaceInGB`: Returns the amount of free space available on the device's external storage in gigabytes.
        - `getTotalExternalDiskSpaceInGB`: Returns the total amount of space available on the device's external storage in gigabytes.
        - `getUsedExternalDiskSpaceInGB`: Returns the amount of used space on the device's external storage in gigabytes.
        - `getFreeExternalDiskSpaceInMB`: Returns the amount of free space available on the device's external storage in megabytes.
        - `getTotalExternalDiskSpaceInMB`: Returns the total amount of space available on the device's external storage in megabytes.
        - `getUsedExternalDiskSpaceInMB`: Returns the amount of used space on the device's external storage in megabytes.

---

### Version 0.0.6 - 2024-12-15

#### Added
- **Methods:**
    - `getStorageSpaceInMB`: Retrieve storage information in megabytes (MB).
    - `getStorageSpaceInGB`: Retrieve storage information in gigabytes (GB).
    - `getSizeOfDirectoryInMB`: Get the size of a specified directory in megabytes (MB).
    - `getStorageTypeFromPath`: Determine if a given path is internal or external storage.
    - `calculateStorageUsage`: Calculate the percentage of storage used based on used and total storage.
    - `isLowOnStorage`: Check if storage usage is below a specific threshold for internal or external storage.

#### Updated
- Enhanced `README.md` with detailed usage examples and documentation.
- Minor bug fixes and performance improvements.

---

## Issues and Feedback

Please file [issues](https://github.com/JaberQayad/flutter_storage_info/issues) to send feedback or report a bug. Thank you!

