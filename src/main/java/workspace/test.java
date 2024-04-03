package workspace;

public class test {
    public static void main(String[] args) {
        int age = 222;
        try {
            saveAge(age);
            System.out.println("saveAge底层执行是成功的");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("saveAge底层执行是失败的");
        }

        try {
            saveAge2(25);
            System.out.println("saveAge2底层执行是成功的");
        } catch (AgeIllegalException e) {
            e.printStackTrace();
            System.out.println("saveAge2底层执行是失败的");
        }

    }

    // 运行时异常
    public static void saveAge(int age) {
        if (age >= 0 && age < 150) {
            System.out.println("年龄被成功保存：" + age);
        } else {
            throw new AgeIllegalRuntimeException("age is illegal, your age is " + age);
        }
    }

    // 编译时异常
    public static void saveAge2(int age) throws AgeIllegalException{
        if (age >= 0 && age < 150) {
            System.out.println("年龄被成功保存：" + age);
        } else {
            throw new AgeIllegalException("age is illegal, your age is " + age);
        }
    }
}

