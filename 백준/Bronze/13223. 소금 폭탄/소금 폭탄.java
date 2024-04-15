import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(":");
        String[] target = br.readLine().split(":");
        int res = 0;
        if((Integer.parseInt(input[0])*60*60+Integer.parseInt(input[1])*60+Integer.parseInt(input[2])
                >= Integer.parseInt(target[0])*60*60+Integer.parseInt(target[1])*60+Integer.parseInt(target[2]))){
            res =  24*60*60+ Integer.parseInt(target[0])*60*60+Integer.parseInt(target[1])*
            60+Integer.parseInt(target[2]) - (Integer.parseInt(input[0])*60*60+Integer.parseInt(input[1])*60+Integer.parseInt(input[2]));
        }else{
            res = Integer.parseInt(target[0])*60*60+Integer.parseInt(target[1])*
                    60+Integer.parseInt(target[2])-(Integer.parseInt(input[0])*60*60+Integer.parseInt(input[1])*60+Integer.parseInt(input[2]));
        }
        String hours = "";
        String mins = "";
        String secs = "";
        int hour = res/3600;
        if(hour < 10){
            hours = "0"+ hour;
        }else{
            hours = ""+ hour;
        }
        int min = (res%3600)/60;
        if(min < 10){
            mins = "0"+ min;
        }else{
            mins = ""+ min;
        }
        int sec = res%60;
        if(sec < 10){
            secs = "0"+ sec;
        }else{
            secs = ""+ sec;
        }
        System.out.println(hours+":"+mins+":"+secs);

    }
}