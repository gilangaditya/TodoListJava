public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * menampilkan todo list
     */
    public static void showTodoList(){
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++ ){
            var todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }

    }

    public static void testShowTodoList(){
        model[0] = "belajar java dasar";
        model[1] = "belajar mmbuat todo list";
        showTodoList();

    }

    /**
     * menambahkan todo list
     */
    public static void addTodoList(String todo){
        System.out.println("MENAMBAHKAN TODO");
//        mengecek apakah todo penuh atau tidak
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
             //   model isFull
                isFull = false;
                break;
            }
        }

//        jika penuh maka resize todo
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }


//        tambahkan data ke dalam todo list
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }
    
    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("contoh add todo." + i);

        }
        showTodoList();
    }

    /**
     * menghapus todo list
     */
    public static boolean deleteTodoList(Integer number){
        System.out.println("MENGHAPUS TODO1");
        if (number - 1 >= model.length){
            return false;
        } else if (model[number - 1] == null) {
            return false;
        }else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)){
                    model[i] = null;
                }else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }

    }

    public static void testDeleteTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        var result = deleteTodoList(20);
        System.out.println(result);

        result = deleteTodoList(7);
        System.out.println(result);

        result = deleteTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("nama");
        System.out.println("Hi " + name);

        var channel = input("channel");
        System.out.println(channel);
    }

    /**
     * view melihat todo list
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewDeleteTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilhan Tidak Dimengerti");
            }
        }

    }

    public static void testViewTodoList(){
        System.out.println("satu");
        System.out.println("dua");
        System.out.println("tiga");
        System.out.println("4");

        viewShowTodoList();
    }

    /**
     * view menambahkan todo list
     */
    public static void viewAddTodoList(){
        System.out.println("tambahkan todo list");

        var todo = input("Todo (x. jika batal)");
        if (todo.equals("x")){
//            batal
        }else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        viewAddTodoList();

        showTodoList();
    }

    /**
     * view menghapus todo list
     */
    public static void  viewDeleteTodoList(){
        System.out.println("menghapus todo list");

        var number = input("nomer todo list yang akan dihapus (x jika batal)");

        if (number.equals("x")){
//            batal
        }else {
            boolean success = deleteTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("gagal menghapus todo list :" + number);
            }
        }
    }

    public static void testViewDeleteTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();

        viewDeleteTodoList();

        showTodoList();
    }
}
