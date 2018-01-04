package dynamic.configuration.manager.enums;

public enum AccessibleType {
    INTEGER, DOUBLE, STRING, BOOLEAN;

    public static AccessibleType[] returnVal() {
        return AccessibleType.values();
    }
}
