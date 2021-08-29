package com.infosat.appRecruitment.security.service;

import com.infosat.appRecruitment.exceptions.PostuleInfosNotFoundException;
import com.infosat.appRecruitment.model.PostuleInfos;
import com.infosat.appRecruitment.repository.PostuleInfosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostuleService {
    private final PostuleInfosRepository postuleInfosRepository;

    @Autowired
    public PostuleService(PostuleInfosRepository postuleInfosRepository) {
        this.postuleInfosRepository = postuleInfosRepository;
    }

    public PostuleInfos addPostuleInfos(PostuleInfos postuleInfos) {
        return postuleInfosRepository.save(postuleInfos);
    }

    public List<PostuleInfos> findAllPostInfos() {
        return postuleInfosRepository.findAll();
    }

    public PostuleInfos findPostuleInfosById(Long id) {
        return postuleInfosRepository.findPostuleInfosById(id)
                .orElseThrow(() -> new PostuleInfosNotFoundException("PostInfos by id " + id + " was not found"));
    }
}

