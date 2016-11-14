package com.building.dto;

/**
 * Created by phuongtn2 on 11/14/2016.
 */
public class AssetCommentReplyDto extends DefaultObjectDto{
    private long assetCommentReplyId;
    private long assetId;
    private String message;
    private byte type;

    public long getAssetCommentReplyId() {
        return assetCommentReplyId;
    }

    public void setAssetCommentReplyId(long assetCommentReplyId) {
        this.assetCommentReplyId = assetCommentReplyId;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}
