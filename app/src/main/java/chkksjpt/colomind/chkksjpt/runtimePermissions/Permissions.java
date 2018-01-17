package chkksjpt.colomind.chkksjpt.runtimePermissions;

/**
 * Created by Administrator on 2017/12/7.
 * Enum class to handle the different states
 * of permissions since the PackageManager only
 * has a granted and denied state.
 */
enum Permissions {
    GRANTED,
    DENIED,
    NOT_FOUND
}