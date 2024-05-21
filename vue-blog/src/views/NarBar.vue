<script setup>
import { ElMessage, ElMessageBox } from 'element-plus';
import { useRouter } from 'vue-router';

import { useUserStore } from '@/store/modules/user/index';
const userStore = useUserStore()
const router = useRouter();
const logout = function () {

  ElMessageBox.confirm(
    '你确认退出吗？', '温馨提示',
    {
      type: 'warning',
      confirmButtonText: '确认',
      cancelButtonText: '取消'
    }
  )
    .then(() => {
      ElMessage({
        type: 'success',
        message: '退出成功'
      })
      setTimeout(2000)
      //移除token
      userStore.clearUserInfo()
      //跳转到登入界面
      router.push(
        {
          path: '/'
        }
      )
    })
    .catch(()=>{
      ElMessage({
        type: 'info',
        message: '已取消'
      })
    })

}

</script>

<template>
  <div class="nav">
    <div class="title">
      <el-icon size="30px">
        <Reading />
      </el-icon>
      <div style="padding: 5px;">
        欢迎进入博客管理系统
      </div>
    </div>
    <div class="button" style="margin: auto 20px;">
      <el-button type="primary" plain @click="logout()">退出</el-button>
    </div>
  </div>
</template>

<style scoped>
.nav {
  display: flex;
  justify-content: space-between;
  position: fixed;
  width: 100%;
  height: 50px;
  background-color: rgb(134, 222, 237);
  box-shadow: --el-box-shadow-dark;
}

.title {
  display: flex;
  margin: auto 20px;
}
</style>
