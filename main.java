class Main{
    public static void main(String[] args) {
        /*HugeInteger invalid1, invalid2, invalid3, random2;
        try{
            invalid1 = new HugeInteger("1$#");
        }
        catch(Exception e){
            System.out.println("error:" + e);
        }
        try{
            invalid2 = new HugeInteger("3.141596535");
        }
        catch(Exception e){
            System.out.println("error:" + e);
        }
        try{
            invalid3 = new HugeInteger("00-4671");
        }
        catch(Exception e){
            System.out.println("error:" + e);
        }
        HugeInteger valid1= new HugeInteger("99");
        HugeInteger valid2= new HugeInteger("21");
        HugeInteger empty= new HugeInteger("");
        HugeInteger large= new HugeInteger("123456789012345678901234567890");

        HugeInteger negative1= new HugeInteger("-357184");
        HugeInteger negative2= new HugeInteger("-00871162");

        HugeInteger random1= new HugeInteger(8);
        try{
            random2= new HugeInteger(0);
        }
        catch(Exception e){
            System.out.println("error:" + e);
        }
        invalid1=new HugeInteger("12300");
        invalid2=new HugeInteger("30000000000");
        invalid3= new HugeInteger("0004671");

        random2= new HugeInteger("0");

        System.out.println(invalid1.toString());
        System.out.println(invalid2.toString());
        System.out.println(invalid3.toString());
        System.out.println(valid1.toString());
        System.out.println(valid2.toString());
        System.out.println(empty.toString());
        System.out.println(large.toString());
        System.out.println(negative1.toString());
        System.out.println(negative2.toString());
        System.out.println(random1.toString());
        System.out.println(random2.toString());
        System.out.println(valid2.add(valid1));  

        System.out.println("Add/Subtract");
        HugeInteger a= new HugeInteger("-565");
        HugeInteger b= new HugeInteger("-800");
        HugeInteger c= new HugeInteger("-7891");
        HugeInteger d= new HugeInteger("8765");
        HugeInteger e= new HugeInteger("8999");
        HugeInteger f= new HugeInteger("-9946");
        HugeInteger g= new HugeInteger("8917");
        HugeInteger h= new HugeInteger("-4884");
        HugeInteger i= new HugeInteger("7561");
        HugeInteger j= new HugeInteger("1128");
        HugeInteger k= new HugeInteger("-12345");
        HugeInteger l= new HugeInteger("-45678");

        System.out.println("1."+a.add(b).toString());
        System.out.println("2."+c.add(d).toString());
        System.out.println("3."+e.subtract(f).toString());
        System.out.println("4."+g.add(h).toString());
        System.out.println("5."+i.subtract(j).toString());
        System.out.println("6."+k.subtract(l).toString());

        System.out.println("\nMultiply");
        HugeInteger m= new HugeInteger("-37649");
        HugeInteger n= new HugeInteger("-2789");
        HugeInteger o= new HugeInteger("-817421");
        HugeInteger p= new HugeInteger("1879982");
        HugeInteger q= new HugeInteger("-99999");
        HugeInteger r= new HugeInteger("-11111");

        System.out.println("1."+m.multiply(n).toString());
        System.out.println("2."+o.multiply(p).toString());
        System.out.println("3."+q.multiply(r).toString());

        System.out.println("\nCompareTo");
        HugeInteger s= new HugeInteger("-9999");
        HugeInteger t= new HugeInteger("-20000");
        HugeInteger u= new HugeInteger("999");
        HugeInteger v= new HugeInteger("1000");
        HugeInteger w= new HugeInteger("1001");
        HugeInteger x= new HugeInteger("3486");
        HugeInteger y= new HugeInteger("1234");

        System.out.println("1."+s.compareTo(t));
        System.out.println("2."+u.compareTo(v));
        System.out.println("3."+w.compareTo(w));
        System.out.println("4."+x.compareTo(y));*/

        HugeInteger big1, big2, big3;
        int compare;
        long starttime, endtime;
        double runtime=0.0;
        for(int i=0; i<100; i++){
            big1= new HugeInteger(10000);
            big2= new HugeInteger(10000);
            starttime= System.currentTimeMillis();
            for(int j=0; j<5000; j++){
                compare= big1.compareTo(big2);
            }
            endtime= System.currentTimeMillis();
            runtime+= (endtime-starttime);
        }
        runtime=runtime/5000;
        System.out.println(runtime);

        runtime=0.0;
        for(int i=0; i<100; i++){
            big1= new HugeInteger(10000);
            big2= new HugeInteger(10000);
            starttime= System.currentTimeMillis();
            for(int j=0; j<500; j++){
                big3= big1.add(big2);
            }
            endtime= System.currentTimeMillis();
            runtime+= (endtime-starttime);
        }
        runtime=runtime/500/100;
        System.out.println(runtime);

        runtime=0.0;
        for(int i=0; i<100; i++){
            big1= new HugeInteger(10000);
            big2= new HugeInteger(10000);
            starttime= System.currentTimeMillis();
            for(int j=0; j<500; j++){
                big3= big1.subtract(big2);
            }
            endtime= System.currentTimeMillis();
            runtime+= (endtime-starttime);
        }
        runtime=runtime/500/100;
        System.out.println(runtime);

        runtime=0.0;
        for(int i=0; i<100; i++){
            big1= new HugeInteger(100);
            big2= new HugeInteger(100);
            starttime= System.currentTimeMillis();
            for(int j=0; j<100; j++){
                big3= big1.multiply(big2);
            }
            endtime= System.currentTimeMillis();
            runtime+= (endtime-starttime);
        }
        runtime=runtime/100/100;
        System.out.println(runtime);
    }
}