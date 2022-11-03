public class PyramidExercise {

    static String a;

    public static void testStringBuilder() {
        long time = System.currentTimeMillis();
        for( int i = 0; i < 10000000; i++ ) {
            StringBuilder sb = new StringBuilder();
            sb.append( "someString" );
            sb.append( "someString2"+i );
            sb.append( "someStrin4g"+i );
            sb.append( "someStr5ing"+i );
            sb.append( "someSt7ring"+i );
            a = sb.toString();
        }
        System.out.println( System.currentTimeMillis()-time );
        time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < 10000000; i++ ) {
            sb.delete( 0, sb.length() );
            sb.append( "someString" );
            sb.append( "someString2"+i );
            sb.append( "someStrin4g"+i );
            sb.append( "someStr5ing"+i );
            sb.append( "someSt7ring"+i );
            a = sb.toString();
        }
        System.out.println( System.currentTimeMillis()-time );
    }

    public static void main(String[] args) {
        int a = 0, b = 1;
        int c;
        StringBuilder sb = new StringBuilder(13);

        for (int i = 2; i < 8; i++) {
            c = a + b;
            a = b;
            b = c;
            for (int j = 0;j < c ;j++) {
                sb.append(c);
            }
            System.out.println(" " + sb);
            sb.setLength(0);
        }

        testStringBuilder();
    }
}
