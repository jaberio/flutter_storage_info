# Security Policy

## Supported Versions

| Version | Supported |
|---------|-----------|
| 0.0.6   | ✅ Yes     |

## Reporting a Vulnerability

If you discover a security vulnerability in **Flutter Storage Info**, we encourage responsible disclosure.

Please open a GitHub issue with a clear and detailed description of the problem. If the issue is sensitive or could pose a risk to users, please mark it appropriately or use GitHub's private reporting features.

## Scope of Security Considerations

This plugin interacts with device storage and may access:
- Internal and external storage directories
- Directory sizes
- Storage usage statistics

**Important**: Applications using this plugin should take care not to expose or store sensitive user data insecurely.

## Permissions Required

For Android, add the following permissions in `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```
⚠️ Note: As of Android 10+ (API level 29+), scoped storage changes apply. Adjust your permission handling accordingly.

## Best Practices
Always check and request storage permissions at runtime.

Validate permissions before accessing storage directories.

Use try-catch blocks to handle potential exceptions related to file system access.

Avoid hardcoding paths and ensure compatibility across Android versions.

Regularly test and audit permission-related flows in your app.

## Dependencies
This plugin has no external runtime dependencies, minimizing its vulnerability surface. Developers are advised to audit all dependencies used in their app ecosystem.
