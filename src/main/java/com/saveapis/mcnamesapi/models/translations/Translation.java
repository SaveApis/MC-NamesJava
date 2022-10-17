package com.saveapis.mcnamesapi.models.translations;

import java.util.List;

public class Translation {
    private TranslationInfo info;
    private List<TranslationContent> content;

    public TranslationInfo getInfo() {
        return info;
    }

    public void setInfo(TranslationInfo info) {
        this.info = info;
    }

    public List<TranslationContent> getContent() {
        return content;
    }

    public void setContent(List<TranslationContent> content) {
        this.content = content;
    }
}
