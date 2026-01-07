package com.jaberio.flutter_storage_info

import android.content.Context
import android.os.Environment
import android.os.StatFs
import androidx.core.content.ContextCompat.getExternalFilesDirs
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import java.io.File

/** A Flutter plugin to retrieve information about device storage. */
class FlutterStorageInfoPlugin : FlutterPlugin, MethodCallHandler {
    private lateinit var channel: MethodChannel
    private lateinit var context: Context

    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "flutter_storage_info")
        channel.setMethodCallHandler(this)
        context = flutterPluginBinding.applicationContext
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        when (call.method) {
            // Internal storage
            "getStorageFreeSpace" -> result.success(getStorageFreeSpace())
            "getStorageUsedSpace" -> result.success(getStorageUsedSpace())
            "getStorageTotalSpace" -> result.success(getStorageTotalSpace())
            // External storage
            "getExternalStorageTotalSpace" -> result.success(getExternalStorageTotalSpace())
            "getExternalStorageFreeSpace" -> result.success(getExternalStorageFreeSpace())
            "getExternalStorageUsedSpace" -> result.success(getExternalStorageUsedSpace())
            // Storage space in MB
            "getStorageFreeSpaceInMB" -> result.success(getStorageFreeSpaceInMB())
            "getStorageUsedSpaceInMB" -> result.success(getStorageUsedSpaceInMB())
            "getStorageTotalSpaceInMB" -> result.success(getStorageTotalSpaceInMB())
            // Storage space in GB
            "getStorageFreeSpaceInGB" -> result.success(getStorageFreeSpaceInGB())
            "getStorageUsedSpaceInGB" -> result.success(getStorageUsedSpaceInGB())
            "getStorageTotalSpaceInGB" -> result.success(getStorageTotalSpaceInGB())
            // External storage space in MB
            "getExternalStorageTotalSpaceInMB" -> result.success(getExternalStorageTotalSpaceInMB())
            "getExternalStorageFreeSpaceInMB" -> result.success(getExternalStorageFreeSpaceInMB())
            "getExternalStorageUsedSpaceInMB" -> result.success(getExternalStorageUsedSpaceInMB())
            // External storage space in GB
            "getExternalStorageTotalSpaceInGB" -> result.success(getExternalStorageTotalSpaceInGB())
            "getExternalStorageFreeSpaceInGB" -> result.success(getExternalStorageFreeSpaceInGB())
            "getExternalStorageUsedSpaceInGB" -> result.success(getExternalStorageUsedSpaceInGB())
            // Directory size
            "getSizeOfDirectoryInMB" -> {
                val directory: String? = call.argument("directory")
                if (directory != null) {
                    result.success(getSizeOfDirectoryInMB(directory))
                } else {
                    result.error("MISSING_DIRECTORY", "Directory path argument is missing", null)
                }
            }
            else -> result.notImplemented()
        }
    }

    private fun getStorageTotalSpace(): Long {
        val path: File = Environment.getExternalStorageDirectory()
        val stat = StatFs(path.path)
        return stat.totalBytes
    }

    private fun getStorageFreeSpace(): Long {
        val path: File = Environment.getExternalStorageDirectory()
        val stat = StatFs(path.path)
        return stat.availableBytes
    }

    private fun getStorageUsedSpace(): Long {
        return getStorageTotalSpace() - getStorageFreeSpace()
    }

    private fun getExternalStorageTotalSpace(): Long {
        val dirs: Array<File> = getExternalFilesDirs(context, null)
        if (dirs.size > 1 && dirs[1] != null) {
            val stat = StatFs(getBaseStoragePath(dirs[1]))
            return stat.totalBytes
        }
        return 0
    }

    private fun getExternalStorageFreeSpace(): Long {
        val dirs: Array<File> = getExternalFilesDirs(context, null)
        if (dirs.size > 1 && dirs[1] != null) {
            val stat = StatFs(getBaseStoragePath(dirs[1]))
            return stat.availableBytes
        }
        return 0
    }

    private fun getExternalStorageUsedSpace(): Long {
        return getExternalStorageTotalSpace() - getExternalStorageFreeSpace()
    }

    private fun getStorageFreeSpaceInMB(): Double {
        return getStorageFreeSpace().toDouble() / 1024 / 1024
    }

    private fun getStorageUsedSpaceInMB(): Double {
        return getStorageUsedSpace().toDouble() / 1024 / 1024
    }

    private fun getStorageTotalSpaceInMB(): Double {
        return getStorageTotalSpace().toDouble() / 1024 / 1024
    }

    private fun getStorageFreeSpaceInGB(): Double {
        return getStorageFreeSpace().toDouble() / 1024 / 1024 / 1024
    }

    private fun getStorageUsedSpaceInGB(): Double {
        return getStorageUsedSpace().toDouble() / 1024 / 1024 / 1024
    }

    private fun getStorageTotalSpaceInGB(): Double {
        return getStorageTotalSpace().toDouble() / 1024 / 1024 / 1024
    }

    private fun getExternalStorageTotalSpaceInMB(): Double {
        return getExternalStorageTotalSpace().toDouble() / 1024 / 1024
    }

    private fun getExternalStorageFreeSpaceInMB(): Double {
        return getExternalStorageFreeSpace().toDouble() / 1024 / 1024
    }

    private fun getExternalStorageUsedSpaceInMB(): Double {
        return getExternalStorageUsedSpace().toDouble() / 1024 / 1024
    }

    private fun getExternalStorageTotalSpaceInGB(): Double {
        return getExternalStorageTotalSpace().toDouble() / 1024 / 1024 / 1024
    }

    private fun getExternalStorageFreeSpaceInGB(): Double {
        return getExternalStorageFreeSpace().toDouble() / 1024 / 1024 / 1024
    }

    private fun getExternalStorageUsedSpaceInGB(): Double {
        return getExternalStorageUsedSpace().toDouble() / 1024 / 1024 / 1024
    }

    private fun getSizeOfDirectoryInMB(directory: String): Double {
        return File(directory)
            .walkTopDown()
            .map { it.length() }
            .sum().toDouble() / 1024 / 1024
    }

    private fun getBaseStoragePath(directory: File): String {
        return if (!directory.path.contains("Android")) {
            directory.path
        } else {
            directory.path.split("Android")[0]
        }
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }
}