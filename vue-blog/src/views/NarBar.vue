<script setup>
  import { useRouter } from 'vue-router';
  const router = useRouter();
  const logout = function(){
    router.push(
      {
        path:'/'
      }
    )
  }
</script>

<template>
  <div class="nav">
    <div class="title">欢迎进入博客管理系统</div>
    <div class="person">个人信息</div>
    <div class="button">
      <el-button type="primary" plain @click="logout()">退出</el-button>
    </div>
  </div>
</template>

<style scoped>
  .nav{
    display: flex;
    justify-content: space-between;
    position: fixed;
    width: 100%;
    height: 50px;
    background-color: rgb(134, 222, 237);
    box-shadow: --el-box-shadow-dark;
  }
  .title{
    margin-left: 20px;
    margin-top: 20px;
  }
  
</style>
