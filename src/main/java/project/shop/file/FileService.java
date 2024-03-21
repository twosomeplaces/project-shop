package project.shop.file;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileMapper fileMapper;

    @Transactional
    public void saveFiles(final Long postId, final List<FileRequest> files) {
        if (CollectionUtils.isEmpty(files)) {
            return;
        }
        for (FileRequest file : files) {
            file.setPostId(postId);
        }
        fileMapper.saveAll(files);
    }

}
