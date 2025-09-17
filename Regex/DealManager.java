package Regex;

import java.util.*;

public class DealManager<T extends Deal> {
    private Map<String, T> dealMap = new HashMap<>();
    private Set<String> seenCodes = new HashSet<>();

    // Add only valid and unique deals
    public void addDeal(String code, String description, T deal) {
        if (!deal.isExpired() && !seenCodes.contains(code)) {
            dealMap.put(code, deal);
            seenCodes.add(code);
        }
    }

    // Sort by discount using Comparator
    public List<T> getSortedDealsByDiscount() {
        List<T> list = new ArrayList<>(dealMap.values());
        list.sort(Comparator.comparingInt(Deal::getDiscountPercent).reversed());
        return list;
    }

    public void printDeals() {
        for (T deal : getSortedDealsByDiscount()) {
            System.out.println(deal);
        }
    }
}
