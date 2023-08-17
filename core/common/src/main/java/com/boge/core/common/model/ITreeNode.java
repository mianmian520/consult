package com.boge.core.common.model;

import java.util.List;

/**
 * 树结构节点
 * 树结构实现该接口
 * @Author boge
 * @Date 2022/9/15 13:02
 */
public interface ITreeNode<T> {

    /**
     * 获取节点id
     * @return T
     */
    T id();

    /**
     * 父节点id
     * @return T
     */
    T pid();

    /**
     * 排序序号
     * @return 排序序号
     */
    int sort();

    /**
     * 是否根节点
     * @return 是否根节点
     */
    boolean root();

    /**
     * 设置该节点的孩子节点列表
     * @param children 孩子节点列表
     */
    void setChildren(List<? extends ITreeNode<T>> children);

    /**
     * 获取该节点的孩子节点列表
     * @return 孩子节点列表
     */
    List<? extends ITreeNode<T>> getChildren();
}
