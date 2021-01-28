public class HugeInteger{
    private int num[]; //where the huge integer is held
    private int size; //number of digits in the number
    private int sign; //1 positive 0 is negative

    public int getNum(int n){ //returns a value of the array
        return this.num[n];
    }

    public int getSize(){ //gets the size of the array
        return this.size;
    }

    public HugeInteger(String val){ // turns a string into an array
        if(!val.isEmpty() && val.charAt(0)=='-'){
            val = val.substring(1);
            sign=0;
        }
        else{
            sign=1;
        }

        for (char k : val.toCharArray()) {
            if(k <'0' || k>'9'){
                throw new IllegalArgumentException("Only digits possible");
            }
        }

        int j=0;
        while(j<val.length() && val.charAt(j)=='0'){
            j++;
        }
        val=val.substring(j);
        size= val.length();  //sets the size
        String a[]=val.split(""); // makes an array of string values of each number
        
        if(size==0){ // creates an empty array if there is an empty string
            num = new int[1];
            num[0] = 0;
            size=1;
        }
        else{
            num = new int[val.length()];
            for(int i=0; i<val.length(); i++){
                num[i]=Integer.parseInt(a[i]); // adds to array while teurning string to an int
            }
        }
          
    }


    public HugeInteger(int n){ //creates a random HugeInteger
  
        if(n<1){ // checks if input is 0
            throw new IllegalArgumentException("Cannot input 0");
        }
        else{
            size=n;
            num= new int[size];
            sign=(int)(Math.random()*2);
            num[0]=(int)(Math.random()*9) +1; //makes sure the first value in array is not 0
            for(int i=1; i<n; i++){
                num[i]=(int)(Math.random()*10); //inputs random values for rest of the array
            }
        }

    }

    public HugeInteger(int n, int m){ //constructs a number with n digits of m
        sign=1;
        size= n;
        num= new int [size];
        for(int i=0; i<size; i++){
            num[i]= m;
        }
    }

    public String toString(){ // oututs number as a string
        String number= ""; //creates string
        if(sign==0){
            number+="-";
        }
        for(int i=0; i<size; i++){
            number += num[i]; //adds each integer which automatically becomes a string when added
        }
        return number;
    }
    public HugeInteger add(HugeInteger h){
        HugeInteger sum= new HugeInteger("0");
        if(sign==1 && h.sign==1){
            sum= this.adds(h);
            sum.sign=1;
        }
        else if(sign==0 && h.sign==0){
            sum= this.adds(h);
            sum.sign=0;
        }
        else if(sign==1 && h.sign==0){
            HugeInteger a= h;
            a.sign=1;
            sum= this.subtracts(a);
        }
        else if(sign==0 && h.sign==1){
            HugeInteger a= this;
            a.sign=1;
            sum= h.subtracts(a);
        }

        return sum;
    }

    public HugeInteger subtract(HugeInteger h){
        HugeInteger diff= new HugeInteger("0");
        if(sign==1 && h.sign==1){
            diff= this.subtracts(h);
        }
        else if(sign==0 && h.sign==0){
            HugeInteger a= this;
            a.sign=1;
            HugeInteger b= h;
            b.sign=1;
            diff= b.subtracts(a);
        }
        else if(sign==1 && h.sign==0){
            diff= this.adds(h);
            diff.sign=1;
        }
        else if(sign==0 && h.sign==1){
            diff= this.adds(h);
            diff.sign=0;
        }

        return diff;
    }

    public HugeInteger adds(HugeInteger h){ //adds this and h
        
        int newsize = h.size > this.size ? h.size : this.size; //chooses the larger number size
        HugeInteger tempthis= new HugeInteger("");
        HugeInteger temph= new HugeInteger("");
        if(size!=newsize){ 
//changes the size of the this HugeInteger to the bigger values if it alreadys isnt by adding zeroes
            int thisnew[]= new int[newsize];
            for(int i=0; i<size; i++){
                thisnew[newsize-1-i]= num[size-1-i]; // subst all this values into the new array
            } 
            tempthis.num=thisnew; //makes the the new array into the current 
            tempthis.size= newsize;
        }
        else{
            tempthis.num= num;
            tempthis.size= size;
        }
        if(h.size!=newsize){ 
//changes the size of the h HugeInteger to the bigger values if it alreadys isnt by adding zeroes
            int hnew[]= new int[newsize];
            for(int j=0; j<h.size; j++){
                hnew[newsize-1-j]= h.num[h.size-1-j]; // subst all h values into the new array
            } 
            temph.num=hnew;
            temph.size= newsize;
        }
        else{
            temph.num=h.num;
            temph.size=h.size;
        }
        HugeInteger sum= new HugeInteger(newsize, 0);
        int carry=0;
        for(int k=0; k<newsize; k++){
            sum.num[sum.size-1 -k]= (carry+ tempthis.num[tempthis.size-1-k]+ temph.num[temph.size-1-k])%10;
            carry= (carry+ tempthis.num[tempthis.size-1-k]+ temph.num[temph.size-1-k])/10;
        }
        if(carry !=0){
            int newarray[]= new int[newsize+1];
            for(int l=0; l<newsize; l++){
                newarray[newsize-l]=sum.num[newsize-1-l];
            }
            newarray[0]=carry;
            sum.num=newarray;
            sum.size=newsize+1;
        }
        return sum;
    }

    public HugeInteger subtracts(HugeInteger h){
        int newsize = h.size > this.size ? h.size : this.size; //chooses the larger number size
        HugeInteger bigger= new HugeInteger("");
        HugeInteger smaller= new HugeInteger("");
        HugeInteger diff= new HugeInteger(newsize, 0);

        int compare=this.compareTo(h);

        if(compare==0){
            diff.num =new int [1];
            diff.size=1;
            diff.sign=1;
            return diff;
        }

        else if(compare==-1){ 
//changes the size of the this HugeInteger to the bigger values if it alreadys isnt by adding zeroes
            int thisnew[]= new int[newsize];
            for(int i=0; i<size; i++){
                thisnew[newsize-1-i]= num[size-1-i]; // subst all this values into the new array
            } 
            smaller.num=thisnew; //makes the the new array into the current 
            smaller.size= newsize;
            bigger.num=h.num;
            bigger.size=newsize;
            diff.sign=0;
        }
        else{
            int hnew[]= new int[newsize];
            for(int i=0; i<h.size; i++){
                hnew[newsize-1-i]= h.num[h.size-1-i]; // subst all this values into the new array
            } 
            smaller.num=hnew; //makes the the new array into the current 
            smaller.size= newsize;
            bigger.num=num;
            bigger.size=newsize;
            diff.sign=1;
        }

        for(int j=0; j<newsize; j++){
            if(bigger.num[newsize-1-j]<smaller.num[newsize-1-j]){
                diff.num[newsize-1-j]= 10+bigger.num[newsize-1-j]-smaller.num[newsize-1-j];
                bigger.num[newsize-2-j]--;
            }
            else{
                diff.num[newsize-1-j]= bigger.num[newsize-1-j]-smaller.num[newsize-1-j];
            }
        }
        int k=0;
        while(diff.num[k]==0){
            k++;
        }
        newsize=newsize-k;
        int[] a= new int[newsize];

        for(int l=0; l<newsize; l++){
            a[l]=diff.num[k+l];
        }
        
        diff.num=a;
        diff.size=newsize;

        return diff;
    }

    public HugeInteger multiply(HugeInteger h){
        int totsize=size+h.size;
        HugeInteger fin= new HugeInteger(totsize,0);
        if((this.size==1 && this.num[0]==0)||(h.size==1 && h.num[0]==0)){
            fin=new HugeInteger(1,0);
            fin.sign=1;
            return fin;
        }
        for(int i=0; i<h.size; i++){
            HugeInteger sum= new HugeInteger(totsize,0);
            int carry=0;
            for(int j=0;j<size;j++){
                sum.num[totsize-i-j-1]=(h.num[h.size-i-1]*num[size-j-1]+carry)%10;
                carry= ((h.num[h.size-i-1]*num[size-j-1])+carry)/10;
                
                if(j==size-1){
                    sum.num[totsize-i-j-2]=carry;
                }
            }
            fin= fin.add(sum);
        }
        if(sign==h.sign)
            fin.sign=1;
        else
            fin.sign=0;
            
        if(fin.num[0]==0){
            totsize=totsize-1;
            int a[]= new int[totsize];
            for(int k=totsize-1; k>=0; k--){
                a[k]=fin.num[k+1];
            }
            fin.num=a;
        }
        fin.size=totsize;
        
        return fin;
    }

    public int compareTo(HugeInteger h){
        int comparison=0;
        if(sign>h.sign)
            comparison=1;
        else if(sign<h.sign)
            comparison=-1;
        else if(h.size>size){
            if(sign==1)
                comparison=-1;
            else
                comparison=1;
        }
        else if(h.size<size){
            if(sign==1)
                comparison=1;
            else
                comparison=-1;
        }
        else{
            for(int i=0;i<size; i++){
                if(h.num[i]>num[i]){
                    if(sign==1){
                        comparison=-1;
                    }
                    else{
                        comparison=1;
                    }
                    break;
                }
                else if(h.num[i]<num[i]){
                    if(sign==1){
                        comparison=1;
                    }
                    else{
                        comparison=-1;
                    }
                    break;
                }
            }
        }
        return comparison;
    }
}