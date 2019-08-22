package com.example.api_task.features.show.model;

import com.example.api_task.features.add.model.AddResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShowResponse {
    @SerializedName("result")
    private ArrayList<Item> items;
    private String targetUrl;
    private boolean success;
    private Error error;
    private boolean unAuthorizedRequest;
    private boolean __abp;

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }

    public boolean isUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public boolean is__abp() {
        return __abp;
    }

    public static class Item {


        private boolean isOnMyWishlist;
        private String name;
        private String description;
        private String imageName;
        private String currencyName;
        private boolean isNew;
        private boolean isOnSale;
        private double price;
        private double rate;
        private double discountPercentage;
        private double discount;
        private double priceAfterDiscount;
        private int brandId;
        private String brandName;
        private String imagePath;
        private String leftLensPower;
        private String rightLensPower;
        private ArrayList<String> leftLensPowerArr;
        private ArrayList<String> rightLensPowerArr;
        private ArrayList<Lens> lensPowerArr;
        private ArrayList<ImageData> itemImages;
        private int id;

        public Item(boolean isOnMyWishlist, String name,
                    String description, String imageName, String currencyName,
                    boolean isNew, boolean isOnSale, double price, double rate, double discountPercentage,
                    double discount, double priceAfterDiscount, int brandId, String brandName, String imagePath,
                    String leftLensPower, String rightLensPower, ArrayList<String> leftLensPowerArr,
                    ArrayList<String> rightLensPowerArr, ArrayList<Lens> lensPowerArr, ArrayList<ImageData> itemImages, int id) {
            this.isOnMyWishlist = isOnMyWishlist;
            this.name = name;
            this.description = description;
            this.imageName = imageName;
            this.currencyName = currencyName;
            this.isNew = isNew;
            this.isOnSale = isOnSale;
            this.price = price;
            this.rate = rate;
            this.discountPercentage = discountPercentage;
            this.discount = discount;
            this.priceAfterDiscount = priceAfterDiscount;
            this.brandId = brandId;
            this.brandName = brandName;
            this.imagePath = imagePath;
            this.leftLensPower = leftLensPower;
            this.rightLensPower = rightLensPower;
            this.leftLensPowerArr = leftLensPowerArr;
            this.rightLensPowerArr = rightLensPowerArr;
            this.lensPowerArr = lensPowerArr;
            this.itemImages = itemImages;
            this.id = id;
        }

        public boolean isOnMyWishlist() {
            return isOnMyWishlist;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getImageName() {
            return imageName;
        }

        public String getCurrencyName() {
            return currencyName;
        }

        public boolean isNew() {
            return isNew;
        }

        public boolean isOnSale() {
            return isOnSale;
        }

        public double getPrice() {
            return price;
        }

        public double getRate() {
            return rate;
        }

        public double getDiscountPercentage() {
            return discountPercentage;
        }

        public double getDiscount() {
            return discount;
        }

        public double getPriceAfterDiscount() {
            return priceAfterDiscount;
        }

        public int getBrandId() {
            return brandId;
        }

        public String getBrandName() {
            return brandName;
        }

        public String getImagePath() {
            return imagePath;
        }

        public String getLeftLensPower() {
            return leftLensPower;
        }

        public String getRightLensPower() {
            return rightLensPower;
        }

        public ArrayList<String> getLeftLensPowerArr() {
            return leftLensPowerArr;
        }

        public ArrayList<String> getRightLensPowerArr() {
            return rightLensPowerArr;
        }

        public ArrayList<Lens> getLensPowerArr() {
            return lensPowerArr;
        }

        public ArrayList<ImageData> getItemImages() {
            return itemImages;
        }

        public int getId() {
            return id;
        }





        public static class Lens {
            private String key;
            private double price;
            private String text;

            public Lens(String key, double price, String text) {
                this.key = key;
                this.price = price;
                this.text = text;
            }

            public String getKey() {
                return key;
            }

            public double getPrice() {
                return price;
            }

            public String getText() {
                return text;
            }
        }


        public static class ImageData {
            private String mediaFileName;
            private String imagePath;
            private int id;

            public ImageData(String mediaFileName, String imagePath, int id) {
                this.mediaFileName = mediaFileName;
                this.imagePath = imagePath;
                this.id = id;
            }

            public String getMediaFileName() {
                return mediaFileName;
            }

            public String getImagePath() {
                return imagePath;
            }

            public int getId() {
                return id;
            }
        }
    }
}
