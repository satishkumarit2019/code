public class GC {
    public static void main(String[] args) {
        GC gc = new GC();
        gc=null;
        System.gc();
        System.out.println("end");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finilized method called");
        System.out.println(10/0);
    }

}

