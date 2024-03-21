package project.shop.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {

    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardDate;
    private int boardView;
    private String mId;
    private int fileNo;

}
