package com.saq.embabel;

import com.embabel.agent.api.annotation.AchievesGoal;
import com.embabel.agent.api.annotation.Action;
import com.embabel.agent.api.annotation.Agent;
import com.embabel.agent.api.common.Ai;
import com.embabel.agent.domain.io.UserInput;

@Agent(description = "Write and review the blog post about a given topic")
public class BlogWriterAgent {

    @Action(description = "Write a first blog draft of blog post")
    public BlogDraft writeDraft (UserInput input, Ai ai){
        return ai
                .withDefaultLlm()
                .withId("blog-post-draft-writer")
                .creating(BlogDraft.class)
                .fromPrompt(""" 
                        You are a software developer and educator writing a blog post.
                        write a blog post about: %s
                        
                        keep it practical and beginner friendly.
                        use short sentences and plain language.
                        Include code example but keep them short and simple
                        Write a content in Markdown.
                        """.formatted(input.getContent()));
    }

    @AchievesGoal(description = "A reviewed and polished blog post")
    @Action(description = "Review and improve draft")
    public ReviewedPost reviewPost (BlogDraft blogDraft, Ai ai) {

        ReviewedPost reviewedPost = ai.withLlmByRole("reviewer")
                .withId("post-reviewer")
                .creating(ReviewedPost.class)
                .fromPrompt("""
                        You are a technical editor. Review and improve this blog post.
                        
                        title: %s
                        content:
                        %s
                        
                        Fix any technical errors. Tighten the writing.
                        Provide the revised title, revised content, and a brief
                        summary of the changes you made as feedback.
                        """.formatted(blogDraft.title(), blogDraft.content()));
        System.out.println(reviewedPost);
        return reviewedPost;
    }
}
