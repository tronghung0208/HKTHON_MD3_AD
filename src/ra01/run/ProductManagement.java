package ra01.run;

import ra01.bussinessImp.Catalog;
import ra01.bussinessImp.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static Scanner sc = new Scanner(System.in);
    public static List<Catalog> catalogList = new ArrayList<>();

    public static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        do {
            System.out.println("********************JAVA-HACKATHON-05-ADVANCE-2-MENU********************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục \n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm  \n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)  \n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm  \n" +
                    "5. Thoát \n");
            System.out.println("Mời nhập lựa chọn!!!");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addCatalog();
                    showCatalogLists();
                    break;
                case 2:
                    addProduct();
                    showProductLists();
                    break;
                case 3:
                    sortByPriceDescending();
                    break;
                case 4:
                    searchProductByCatalogName();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Xin mời chọn lại");
            }
        } while (true);
    }

    // Phần logic cho Catalog
    public static void addCatalog() {
        System.out.println("Nhập số lượng danh mục cần thêm:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin danh mục thứ: " + (i + 1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogList.add(newCatalog);
        }
    }

    public static void showCatalogLists() {
        for (Catalog catalog : catalogList) {
            catalog.displayData();
        }
    }


    // Phần logic cho Product

    public static void addProduct() {
        System.out.println("Nhập số lượng sản phẩm cần thêm:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ: " + (i + 1));
            Product newProduct = new Product();
            newProduct.inputData();
            productList.add(newProduct);
        }
    }

    public static void showProductLists() {
        for (Product product : productList) {
            product.displayData();
        }
    }

    public static void sortByPriceDescending() {
        productList.sort(new Product());

        for (Product element : productList) {
            element.displayData();
        }
    }
    public static void searchProductByCatalogName() {
        System.out.println("Nhập tên danh mục sản phẩm cần tìm kiếm:");
        String catalogNameToSearch = sc.nextLine();

        boolean found = false;

        for (Product product : productList) {
            if (product.getCatalogName().equalsIgnoreCase(catalogNameToSearch)) {
                product.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm trong danh mục này.");
        }
    }


}

