package murach.data;

import murach.business.User;

public class UserDB {
    public static long insert(User user) {
        // Tạm thời chỉ in ra log giả lập việc lưu DB
        System.out.println("User inserted: " + user.getEmail());
        return 0;
    }
}