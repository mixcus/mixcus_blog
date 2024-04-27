<script setup>
import NarBar from './NarBar.vue';

import { reactive } from 'vue';

const menuItems = reactive([
    {
        title: '博客管理',
        path: '1',
        icon: "Document",
        children: [
            {
                title: '博客列表',
                path: '1-1',
                icon: "DocumentCopy",
                router: 'article/articleList',
            },
            {
                title: '添加博客',
                path: '1-2',
                icon: "DocumentAdd",
                router: 'article/articleAdd',
            },

        ]
    },
    {
        title: '评论管理',
        path: '2',
        icon: "ChatLineSquare",
        children: [
            {
                title: '评论列表',
                path: '2-1',
                icon: "ChatSquare",
                router: 'comment/commentList',
            },
        ]
    },
    {
        title: '博客标签管理',
        path: '3',
        icon: "CollectionTag",
        children: [
            {
                title: '标签列表',
                path: '3-1',
                icon: "Collection",
                router: 'articleTag/articleTagList',
            },
        ]
    },
    {
        title: '博客分类管理',
        path: '4',
        icon: "DataAnalysis",
        children: [
            {
                title: '分类列表',
                path: '4-1',
                icon: "DataBoard",
                router: 'category/categoryList',
            }
        ]
    },
    {
        title: '用户管理',
        path: '5',
        icon: "User",
        children: [
            {
                title: '用户列表',
                path: '5-1',
                icon: "UserFilled",
                router: 'user/userList',
            }
        ]
    }
]
)
</script>

<template>

    <div>
        <el-menu class="menu" :router="true" default-active="1">
            <!-- 一级标题 -->
            <el-sub-menu :index="item.path + ''" v-for="item in menuItems" :key="item.path">
                <template #title>
                    <el-icon>
                        <component :is="item.icon" size></component>
                    </el-icon>
                    <span>{{ item.title }}</span>
                </template>
                <!-- 二级标题 -->
                <el-menu-item :index="'/' + subItem.router" v-for="subItem in item.children" :key="subItem.path">
                    <template #title>
                        <el-icon>
                            <component :is="subItem.icon"></component>
                        </el-icon>
                        <span>{{ subItem.title }}</span>
                    </template>
                </el-menu-item>
            </el-sub-menu>
        </el-menu>
    </div>
    <!-- 头部 -->
    <NarBar />
    <div class="main-content">
        <el-main>
            <!-- 显示内容 -->
            <router-view></router-view>
        </el-main>
    </div>
</template>

<style scoped>
.menu {
    margin-top: 50px;
    width: 180px;
    height: 700px;
    position: fixed;
    background-color: white;
}

.main-content {

    background-color: rgba(28, 17, 17, 0.101);
    left: 180px;
    top: 50px;
    width: 100%;
    height: 100%;
    position: fixed;
}
</style>
