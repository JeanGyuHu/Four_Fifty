package a2018_hackathon.navigation;

import java.util.List;

public class Extract_Work {

    List<Node> preferred_Node;

    public Extract_Work(){
        preferred_Node = null;
    }

    private List<Node> find_Work(List<String> select_Work){
        for(int i=0; i<select_Work.size();i++){
            Node work_Node = null;
            switch (select_Work.get(i)){
                case "Work_1":
                    work_Node = new Node(0,0);
                    break;
                case "Work_2":
                    work_Node = new Node(0,9);
                    break;
                case "Work_3":
                    work_Node = new Node(0,15);
                    break;
                case "Work_4":
                    work_Node = new Node(5,9);
                    break;
                case "Work_5":
                    work_Node = new Node(11,0);
                    break;
                case "Work_6":
                    work_Node = new Node(11,9);
                    break;
                case "Work_7":
                    work_Node = new Node(11,15);
                    break;
                    default:
                        break;
            }
            preferred_Node.add(work_Node);
        }
        return preferred_Node;
    }
}
