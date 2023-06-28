package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

public enum TileVariant {
    VARIANT_ONE("1"),
    VARIANT_TWO("2"),
    VARIANT_THREE("3");

    private String number;

    TileVariant(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        switch (this) {
            case VARIANT_ONE:
                return "1";
            case VARIANT_TWO:
                return "2";
            case VARIANT_THREE:
                return "3";
            default:
                return super.toString();
        }
    }

}
