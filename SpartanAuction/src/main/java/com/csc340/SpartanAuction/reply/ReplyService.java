package com.csc340.SpartanAuction.reply;

import com.csc340.SpartanAuction.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    public Reply getReplyById(int id) {
        return replyRepository.findById(id).orElse(null);

    }

    public List<Reply> getAllRepliesForOneReview(int reviewId) {
        return replyRepository.getAllRepliesForOneReview(reviewId);
    }

    public List<Reply> getAllRepliesForOneUser(int userId) {
        return replyRepository.getAllRepliesForOneUser(userId);
    }

    public void addNewReply(Reply reply) {
        if (replyRepository.existsById(reply.getId())) {
            reply = new Reply(reply);
            replyRepository.save(reply);
            return;
        }
        reply = new Reply(reply.getReview(), reply.getPreviousReply(), reply.getComment());
        replyRepository.save(reply);
    }

    public void updateReply(int id, Reply reply) {
        Reply existing = getReplyById(id);
        existing.setReview(reply.getReview());
        existing.setPreviousReply(reply.getPreviousReply());
        existing.setComment(reply.getComment());


        //Technically the 4 lines above are not necessary because the save method merges by default.
        replyRepository.save(existing);
    }

    public void deleteReplyById(int id) {
        replyRepository.deleteById(id);
    }
}

