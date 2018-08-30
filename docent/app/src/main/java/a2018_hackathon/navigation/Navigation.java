package a2018_hackathon.navigation;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Navigation {
    //위도 경도
    double user_latitude;
    double user_longitude;

    AStar museum;


    Node initialNode;
    Node finalNode;

    List<Node> path;

    public ArrayList navi_text_List;

    public Navigation() {

        initialNode = new Node(0,0);
        finalNode = new Node(6,6);

        navi_text_List = new ArrayList();

        museum = new AStar(MapInfo.map_rows,MapInfo.map_cols,initialNode,finalNode);
        museum.setInformations(MapInfo.museum);

        path = museum.findPath();
        for(Node node : path){
            Log.e("노드",node.toString());
        }
    }

    //노드가 가는 경로가 잘 가고 있는지 체크하기
    public boolean user_CheckPosition(List<Node> path,int user_row,int user_col){
        boolean check_Position = false;
        for(Node node : path) {
            if (node.getRow() - 1 >= 0 &&
                    node.getCol() - 1 >= 0 &&
                    node.getRow() + 1 <= MapInfo.map_rows &&
                    node.getCol() + 1 <= MapInfo.map_cols) {
                if (node.getRow() - 1 <= user_row ||
                        user_row <= node.getRow() + 1 ||
                        node.getCol() - 1 <= user_col ||
                        user_col <= node.getCol() + 1) {
                    check_Position = true;
                }
            }
        }
        if(check_Position){
            return true;
        }
        else{
            return false;
        }
    }

    //최소의 F값 찾기
    public  int compare_Minimum(int[] means_transportation){
        int find_Minimum = means_transportation[0];
        for(int i=1;i<means_transportation.length;i++){
            if(find_Minimum >= means_transportation[i]){
                find_Minimum = means_transportation[i];
            }
        }

        int find_component;

        for(find_component=0;find_component<means_transportation.length;find_component++){
            if(find_Minimum == means_transportation[find_component])
                break;
        }

        return find_component;
    }

    public Node get_currentNode(double user_latitude,double user_longitude){
        Node current_Node = null;
        user_latitude -= 37.54715706;
        user_longitude -= 127.07383858;

        double b = 93806;
        double a = 158983;
        double c = 184595;

        user_latitude = a / c * user_latitude + b / c * user_longitude;
        user_longitude = -b / c * user_latitude + a / c * user_longitude;

        int count_row = Integer.parseInt (String.valueOf(user_latitude / 0.00001999));
        int count_col = Integer.parseInt(String.valueOf(user_longitude / 0.00002148));


        current_Node = new Node(count_row,count_col);

        if(count_row < 0 || count_col <0){
            return null;
        }
        else{
            return current_Node;
        }
    }
    //목적지에 대한 노드 얻기

    public String get_Device_bearing(double bearing){
        if(bearing >= MapInfo.up_bearing -45 && bearing <= MapInfo.up_bearing + 45){
            return "앞";
        }
        else if(bearing >= MapInfo.left_bearing -45 && bearing <= MapInfo.left_bearing +45){
            return "왼쪽";
        }
        else if(bearing >= MapInfo.down_bearing -45 && bearing <= MapInfo.down_bearing +45){
            return "아래쪽";
        }
        else{
            return "오른쪽";
        }
    }

    public void Navi_Path(){
        int i=0;

        for(i=0;i<path.size()-1; i++){
            int change_row = 0;
            int change_col = 0;

            String navi_text = "";

            change_row = path.get(i+1).getRow() - path.get(i).getRow();
            change_col = path.get(i+1).getCol() - path.get(i).getCol();

            if(change_row == 1 && change_col ==0){
                navi_text= "아래쪽";
            }
            else if(change_row == -1 && change_col ==0){
                navi_text= "위쪽";
            }
            else if(change_row == 0 && change_col == 1){
                navi_text= "오른쪽";
            }
            else if(change_row == 0 && change_col == -1){
                navi_text= "왼쪽";
            }
            else if(change_row == 1 && change_col ==1){
                navi_text= "오른쪽아래";
            }
            else if(change_row == 1 && change_col ==-1){
                navi_text= "왼쪽아래";
            }
            else if(change_row ==-1 && change_col ==1){
                navi_text= "오른쪽위";
            }
            else if(change_row ==-1 && change_col ==-1){
                navi_text= "왼쪽위";
            }
            else{
                navi_text = "이동수단";
            }


            navi_text_List.add(navi_text);
        }
    }

    public void outPut_Navi(){
        Navi_Path();
        String current_text =(String)navi_text_List.get(0);

        if(current_text.equals("이동수단")){
            Log.e("이동수단","2000 계단 남음");
            navi_text_List.remove(0);
            return ;
        }

        int count = 1 ;

        int i=1;
        while((String)navi_text_List.get(i)== current_text && i != navi_text_List.size()-1){
            i++;
            count++;
        }

        for(int j=0;j<i;j++){
            navi_text_List.remove(0);
        }

        Log.e("방향",current_text);
        Log.e("거리",String.valueOf(count*MapInfo.node_space+"m"));

    }
}
