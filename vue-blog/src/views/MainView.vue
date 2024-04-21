<script setup>


import NarBar from './NarBar.vue';

import { reactive } from 'vue';

const menuItems = reactive([
    {
        title: '博客管理',
        path: '1',
        children: [
            {
                title: '博客列表',
                path: '1-1',
                router: 'article/articleList',
            },
            {
                title: '添加博客',
                path: '1-2',
                router: 'article/articleAdd',
            },

        ]
    },
    {
        title: '评论管理',
        path: '2',
        children: [
            {
                title: '评论列表',
                path: '2-1',
                router: 'comment/commentList',
            },
        ]
    },
    {
        title: '博客标签管理',
        path: '3',
        children: [
            {
                title: '标签列表',
                path: '3-1',
                router: 'articleTag/articleTagList',
            },
        ]
    },
    {
        title: '博客分类管理',
        path: '4',
        children: [
            {
                title: '分类列表',
                path: '4-1',
                router: 'category/categoryList',
            }
        ]
    },
    {
        title: '用户管理',
        path: '5',
        children: [
            {
                title: '用户列表',
                path: '5-1',
                router: 'user/userList',
            }
        ]
    }
]
)
</script>

<template>
    
    <div class="container">
        <el-menu class="menu" :router="true" default-active="1">
            <!-- 一级标题 -->
            <el-sub-menu :index="item.path+''" v-for="item in menuItems" :key="item.path">
                <template #title>
                    <span>{{ item.title }}</span>
                </template>
                <!-- 二级标题 -->
                <el-menu-item :index="'/'+subItem.router" v-for="subItem in item.children" :key="subItem.path">
                    <template #title>
                        <span>{{ subItem.title }}</span>
                    </template>
                </el-menu-item>
            </el-sub-menu>
        </el-menu>
    </div>
    <!-- 头部 -->
    <NarBar />
    <el-main>
        <!-- 显示内容 -->
        <router-view></router-view>
    </el-main>
</template>

<style scoped>
.menu {
    margin-top: 50px;
    width: 300px;
    height: 700px;
    position: fixed;
    background-color: bisque;
}
</style>
