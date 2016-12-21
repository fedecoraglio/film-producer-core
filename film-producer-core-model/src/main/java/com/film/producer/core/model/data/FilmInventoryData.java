package com.film.producer.core.model.data;

public class FilmInventoryData {

    private final long filmId;
    private final String filmTitle;
    private final long inventoryNumber;
    private final long storeId;
    private final String storeAddress;

    private FilmInventoryData(final Builder builder) {
        this.filmId = builder.filmId;
        this.filmTitle = builder.filmTitle;
        this.inventoryNumber = builder.inventoryNumber;
        this.storeId = builder.storeId;
        this.storeAddress = builder.storeAddress;
    }

    public static final class Builder {
        private long filmId;
        private String filmTitle;
        private long inventoryNumber;
        private long storeId;
        private String storeAddress;

        public FilmInventoryData build() {
            return new FilmInventoryData(this);
        }

        public Builder withFilmId(final long filmId) {
            this.filmId = filmId;
            return this;
        }

        public Builder withFilmTitle(final String filmTitle) {
            this.filmTitle = filmTitle;
            return this;
        }

        public Builder withInventoryNumber(final long inventoryNumber) {
            this.inventoryNumber = inventoryNumber;
            return this;
        }

        public Builder withStoreId(final long storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder withStoreAddress(final String storeAddress) {
            this.storeAddress = storeAddress;
            return this;
        }
    }

    public long getFilmId() {
        return filmId;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public long getInventoryNumber() {
        return inventoryNumber;
    }

    public long getStoreId() {
        return storeId;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    @Override
    public String toString() {
        return "FilmInventoryData{" +
                "filmId=" + filmId +
                ", filmTitle='" + filmTitle + '\'' +
                ", inventoryNumber=" + inventoryNumber +
                ", storeId=" + storeId +
                ", storeAddress='" + storeAddress + '\'' +
                '}';
    }
}
