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
    <div class="title">
      <el-icon size="30px"><Reading /></el-icon>
      <div style="padding: 5px;">
        欢迎进入博客管理系统
      </div>
    </div>
    <div class="button" style="margin: auto 20px;">
      <el-button type="primary"  plain @click="logout()">退出</el-button>
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
    display: flex;
    margin: auto 20px;
  }
  
</style>
