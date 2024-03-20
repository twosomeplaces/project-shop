package project.shop.file;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileController {

    // 신규 게시글 생성
    // @PostMapping("/post/save.do")
    // public String savePost(final PostRequest params, Model model) {
    //     Long id = postService.savePost(params);
    //     List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
    //     fileService.saveFiles(id, files);
    //     MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
    //     return showMessageAndRedirect(message, model);
    // }
    
}
