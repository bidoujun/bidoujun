package sjjgysf;

public class MiGongHuiSu {
    public static void main(String[] args) {
        int[][] map=new int[8][7];
        for (int i = 0; i <=map.length-1; i++) {
            for (int j = 0; j <map[i].length ; j++) {
                map[i][j]=0;
            }
        }
        for (int i = 0; i <=map.length-1 ; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        for (int i = 0; i <7 ; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        miGong(map,1,1);
        for (int i = 0; i <map.length; i++) {
            for (int j = 0; j <map[i].length ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
//利用递归栈执行原理 第一个if不断往后走,上下左右都走不通的话,根据栈的执行回溯到上一个if继续执行,通过
//不断回溯来找到出口的路
    public static boolean miGong(int[][] map, int i,int j) {
        //找到出口 6 5
        if(map[6][5]==2){
            return true;
        }else {
            //如果该点是0说明还没有走过
            if(map[i][j]==0){
                map[i][j]=2;
                //先向右走
                if(miGong(map,i,j+1)){
                    return true;
                }else if(miGong(map,i+1,j)){
                    //向下走
                    return true;
                }else if(miGong(map,i,j-1)){
                    //走不通向左走
                    return true;
                }else if(miGong(map, i-1, j)){
                    //最后向上走
                    return true;
                }else{
                    //都走不通
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
