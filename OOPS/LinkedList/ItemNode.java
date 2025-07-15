class ItemNode {
    int id, qty;
    double price;
    String name;
    ItemNode next;

    ItemNode(int id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    ItemNode head;

    void addAtBeginning(ItemNode item) {
        item.next = head;
        head = item;
    }

    void addAtEnd(ItemNode item) {
        if (head == null) {
            head = item;
            return;
        }
        ItemNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = item;
    }

    void addAtPosition(int pos, ItemNode item) {
        if (pos <= 0) { addAtBeginning(item); return; }
        ItemNode curr = head;
        for (int i = 0; i < pos - 1 && curr != null; i++) curr = curr.next;
        if (curr == null) { addAtEnd(item); return; }
        item.next = curr.next;
        curr.next = item;
    }

    void removeById(int id) {
        ItemNode curr = head, prev = null;
        while (curr != null) {
            if (curr.id == id) {
                if (prev == null) head = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    void updateQty(int id, int newQty) {
        ItemNode curr = head;
        while (curr != null) {
            if (curr.id == id) {
                curr.qty = newQty;
                return;
            }
            curr = curr.next;
        }
    }

    ItemNode searchById(int id) {
        ItemNode curr = head;
        while (curr != null) {
            if (curr.id == id) return curr;
            curr = curr.next;
        }
        return null;
    }

    void searchByName(String name) {
        ItemNode curr = head;
        while (curr != null) {
            if (curr.name.equalsIgnoreCase(name)) {
                System.out.println("ID: " + curr.id + ", Qty: " + curr.qty + ", Price: " + curr.price);
            }
            curr = curr.next;
        }
    }

    double totalValue() {
        ItemNode curr = head;
        double total = 0;
        while (curr != null) {
            total += curr.qty * curr.price;
            curr = curr.next;
        }
        return total;
    }

    void sort(String key, boolean asc) {
        head = mergeSort(head, key, asc);
    }

    private ItemNode mergeSort(ItemNode head, String key, boolean asc) {
        if (head == null || head.next == null) return head;
        ItemNode mid = getMiddle(head);
        ItemNode nextToMid = mid.next;
        mid.next = null;
        ItemNode left = mergeSort(head, key, asc);
        ItemNode right = mergeSort(nextToMid, key, asc);
        return merge(left, right, key, asc);
    }

    private ItemNode merge(ItemNode a, ItemNode b, String key, boolean asc) {
        ItemNode dummy = new ItemNode(0, "", 0, 0);
        ItemNode tail = dummy;
        while (a != null && b != null) {
            boolean condition = false;
            if (key.equals("name")) {
                condition = asc ? a.name.compareTo(b.name) < 0 : a.name.compareTo(b.name) > 0;
            } else if (key.equals("price")) {
                condition = asc ? a.price < b.price : a.price > b.price;
            }
            if (condition) {
                tail.next = a; a = a.next;
            } else {
                tail.next = b; b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    private ItemNode getMiddle(ItemNode head) {
        if (head == null) return head;
        ItemNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
        }
        return slow;
    }

    void display() {
        ItemNode curr = head;
        while (curr != null) {
            System.out.println("ID: " + curr.id + ", Name: " + curr.name + ", Qty: " + curr.qty + ", Price: " + curr.price);
            curr = curr.next;
        }
    }
}
