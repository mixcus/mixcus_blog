<script setup>
import { onMounted,inject, ref} from 'vue';
  
  const formData = ref('')

  const axios = inject("$axios")

  onMounted(()=>{
    findPage();
  })

  const findPage = ()=>{
    axios.post('http://localhost:8080/article/getArticleList').then((res)=>{
      console.log(res.data.data)
      console.log(res.data.total)
      formData.value = res.data.data;
    }).catch((e)=>{
      console.log(e);
    })
  }


</script>

<template>
  <div class="content">
    <el-header class="header">
      <span>博客列表</span>
    </el-header>
    <el-table :data="formData" style="width:100%;">

      <el-table-column prop="title" label="标题" width="180" />
      <el-table-column prop="content" label="内容" width="180" />
      <el-table-column prop="likeCount" label="点赞数" width="180" />
      <el-table-column prop="viewCount" label="观看数" width="180" />

    </el-table>
  </div>
  
</template>

<style scoped>

</style>

