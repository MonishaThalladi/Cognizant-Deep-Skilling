public class SearchAlgorithms {

    // Linear Search - O(n)
    public static ProductForSearch linearSearch(ProductForSearch[] products, String searchName) {
        for (ProductForSearch p : products) {
            if (p.getProductName().equalsIgnoreCase(searchName)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search - O(log n)
    public static ProductForSearch binarySearch(ProductForSearch[] products, String searchName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(searchName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void sortProductsByName(ProductForSearch[] products) {
        java.util.Arrays.sort(products, (a, b) -> 
            a.getProductName().compareToIgnoreCase(b.getProductName())
        );
    }
}
