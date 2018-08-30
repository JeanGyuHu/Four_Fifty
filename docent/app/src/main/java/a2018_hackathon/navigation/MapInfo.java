package a2018_hackathon.navigation;

//맵 정보에 대한 상수 클래스
public class MapInfo {

    //벽
    public static final int block = 0;

    //지도 가로 세로 크기
    public static  final int map_rows = 12;
    public static  final int map_cols = 19;

    //작품 정보
    public static final int work_1 = 1;
    public static final int work_2 = 2;
    public static final int work_3 = 3;
    public static final int work_4 = 4;
    public static final int work_5 = 5;
    public static final int work_6 = 6;
    public static final int work_7 = 7;

    //지도 방향
    public static final double up_bearing=0;
    public static final double down_bearing=0;
    public static final double left_bearing=0;
    public static final double right_bearing=0;

    //노드 사이거리
    public static final double node_space = 1.5;

    public static int[][] museum = new int[][]{
            { 1,-1,-1,-1,-1,-1,-1,-1,-1, 2,-1,-1,-1,-1,-1, 3, 0,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0, 0,-1,-1},
            {-1,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1, 4,-1,-1,-1,-1,-1, 0,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1},
            {-1,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0, 0,-1,-1},
            { 5,-1,-1,-1,-1,-1,-1,-1,-1, 6,-1,-1,-1,-1,-1, 7, 0,-1,-1}
    };
}