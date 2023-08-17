package com.boge.core.common.utils;

import cn.hutool.core.collection.CollUtil;
import com.boge.core.common.model.ITreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 对实现ITreeNode接口的工具类
 *
 * @Author boge
 * @Date 2022/9/15 13:07
 */
public class TreeUtils {

    /**
     * 对实现ITreeNode的类列表，转换成树结构
     *
     * @param nodes 列表
     */
    public static <T extends ITreeNode> List<T> generateTrees(List<T> nodes) {
        List<T> roots = new ArrayList<>();
        for (Iterator<T> iterator = nodes.iterator(); iterator.hasNext(); ) {
            T node = iterator.next();
            if (node.root()) {
                roots.add(node);
                iterator.remove();
            }
        }
        roots.forEach(root -> {
            setChildren(root, nodes);
        });
        roots.sort(Comparator.comparing(ITreeNode::sort));
        return roots;
    }

    /**
     * 设置孩子节点，递归
     *
     * @param parent 父节点
     * @param nodes  所有节点
     */
    private static <T extends ITreeNode> void setChildren(T parent, List<T> nodes) {
        List<T> children = new ArrayList<>();
        for (Iterator<T> iterator = nodes.iterator(); iterator.hasNext(); ) {
            T node = iterator.next();
            if (Objects.equals(node.pid(), parent.id())) {
                children.add(node);
                iterator.remove();
            }
        }
        if (children.isEmpty()) {
            return;
        }
        parent.setChildren(children);
        children.forEach(node -> {
            setChildren(node, nodes);
        });
        children.sort(Comparator.comparing(ITreeNode::sort));
    }

    /**
     * 获取树所有的节点数量
     *
     * @param nodes 树
     */
    public static <T extends ITreeNode> int treeNodeNum(List<T> nodes) {
        return childrenNum(new AtomicInteger(nodes.size()), nodes);
    }

    /**
     * 获取孩子节点数量
     */
    private static <T extends ITreeNode> int childrenNum(AtomicInteger atomicInteger, List<T> nodes) {
        nodes.forEach(node -> {
            if (node.getChildren() != null) {
                atomicInteger.addAndGet(node.getChildren().size());
            }
        });
        nodes.forEach(node -> {
            if (node.getChildren() != null) {
                childrenNum(atomicInteger, node.getChildren());
            }
        });
        return atomicInteger.get();
    }

    /**
     * 根据id获取其节点
     */
    public static <T extends ITreeNode> T findNode(List<T> nodes, Object id) {
        T node = null;
        for (T n : nodes) {
            if (Objects.equals(n.id(), id)) {
                node = n;
                break;
            }
            if (node == null && CollUtil.isNotEmpty(n.getChildren())) {
                node = findNode((List<T>) n.getChildren(), id);
            }
        }
        return node;
    }

    public static <T extends ITreeNode> boolean nodeContains(T node, Object id) {
        if (node == null) {
            return false;
        }
        if (CollUtil.isEmpty(node.getChildren())) {
            return false;
        }
        return contains(node.getChildren(), id);
    }

    private static <T extends ITreeNode> boolean contains(List<T> nodes, Object id) {
        boolean flag = false;
        for (T node : nodes) {
            if (Objects.equals(node.id(), id)) {
                flag = true;
                break;
            }
            if (!flag && CollUtil.isNotEmpty(node.getChildren())) {
                flag = contains((List<T>) node.getChildren(), id);
            }
        }
        return flag;
    }
}
