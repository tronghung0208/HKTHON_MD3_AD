package ra01.bussinessImp;

import ra01.bussiness.IShop;
import ra01.run.ProductManagement;

import java.util.Comparator;
import java.util.List;

import static ra01.run.ProductManagement.catalogList;
import static ra01.run.ProductManagement.sc;

public class Product implements IShop, Comparator<Product> {
    public static Comparator<? super Product> compare;
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = this.importPrice * RATE;
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Vui lòng nhập mã sản phẩm: ");
        this.productId = Integer.parseInt(sc.nextLine());
        System.out.println("Vui lòng nhập tên sản phẩm: ");
        this.productName = sc.nextLine();
        System.out.println("Vui lòng nhập tiêu đề sản phẩm: ");
        this.title = sc.nextLine();
        System.out.println("Vui lòng nhập mô tả sp: ");
        this.descriptions = sc.nextLine();

        List<Catalog> catalogList = ProductManagement.catalogList;

        if (catalogList.isEmpty()) {
            System.out.println("Chưa có danh mục nào, hãy thêm danh mục mới: ");
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogList.add(newCatalog);
            setCatalog(catalogList.get(0));
        } else {
            for (Catalog catalog : catalogList) {
                if (catalog != null) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("ID: " + catalog.getCatalogId() + " Name:  " + catalog.getCatalogName());
                }
            }
            System.out.println("Chọn Catalog theo ID:");
            while (true) {

                int id = Integer.parseInt(sc.nextLine());
                boolean flag = false;
                for (Catalog catalog : catalogList) {
                    if (catalog != null && catalog.getCatalogId() == id) {
                        flag = true;
                        this.catalog = catalog;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("ID không đúng, vui lòng nhập lại!!!");
                } else {
                    break;
                }
            }
        }

//        for (Catalog catalog : catalogList) {
//            if (catalog != null) {
//                System.out.println("--------------------------------------------------");
//                System.out.println("ID: " + catalog.getCatalogId() + " Name:  " + catalog.getCatalogName());
//            }
//        }
//        System.out.println("Chọn Catalog theo ID:");
//        while (true) {
//            if (catalogList.isEmpty()){
//                System.out.println("Nhập vào thông tin danh mục bạn muốn thêm");
//                Catalog newCatalog = new Catalog();
//                newCatalog.inputData();
//                catalogList.add(newCatalog);
//            }else {
//                int id = Integer.parseInt(sc.nextLine());
//                boolean flag = false;
//                for (Catalog catalog : catalogList) {
//                    if (catalog != null && catalog.getCatalogId() == id) {
//                        flag = true;
//                        this.catalog = catalog;
//                        break;
//                    }
//                }
//                if (!flag) {
//                    System.out.println("ID không đúng, vui lòng nhập lại!!!");
//                } else {
//                    break;
//                }
//            }
//
//        }
        System.out.println("Vui lòng nhập giá nhập sp: ");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Vui lòng nhập trạng thái hoạt động sản phẩm: ");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %d, Tên sản phẩm: %s, Tiêu đề sản phẩm: %s, Mô tả sản phẩm: %s,", this.productId, this.productName, this.title, this.descriptions);
        System.out.printf(" Catalog: %s, Giá nhập sản phẩm: %.2f, Giá bán sản phẩm: %.2f, Trạng thái sản phẩm: %s\n", this.catalog.getCatalogName(), this.importPrice, this.importPrice * RATE, this.productStatus ? "Đang bán" : "Ngừng bán");
    }


    @Override
    public int compare(Product o1, Product o2) {
        return Float.compare(o1.importPrice, o2.importPrice);
    }


    public String getCatalogName() {
        return this.catalog.getCatalogName();
    }

    public static Comparator<? super Product> getCompare() {
        return compare;
    }

    public static void setCompare(Comparator<? super Product> compare) {
        Product.compare = compare;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
