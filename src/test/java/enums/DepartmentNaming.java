package enums;

public enum DepartmentNaming {
    PRODUCTS("Products"),
    CART("Your Cart"),
    CHECKOUT_YOUR_INFORMATION("Checkout: Your Information"),
    CHECKOUT_OVERVIEW("Checkout: Overview"),
    CHECKOUT_COMPLETE("Checkout: Complete!");

    private final String displayName;

    DepartmentNaming(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
