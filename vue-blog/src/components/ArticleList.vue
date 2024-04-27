<script setup>
import { onMounted, inject, ref } from 'vue';

const formData = ref('')

const axios = inject("$axios")

// 生命周期函数
onMounted(() => {
  findPage();
})

//获取数据
const findPage = () => {
  axios.post('http://localhost:8080/article/getArticleList').then((res) => {
    formData.value = res.data.data;
  }).catch((e) => {
    console.log(e);
  })
}

// 编辑文章处理
const dialogFormVisableEdit = ref(false);

const handleEdit = (row) => {

  //弹出编辑对话框
  dialogFormVisableEdit.value = true;
  //row 表格一整行的数据
  console.log(row);

}

//查询文章
const queryString = ref('');
const formDataRef = ref();
//处理查询
const handleQuery = () => {
  alert(queryString.value)
}

</script>

<template>
  <!-- 列表内容 -->
  <div class="content">
    <el-header class="header">
      <span>查询：</span>
      <el-input type="text" v-model="queryString" style="width: 300px;">
        <template #prefix>
          <el-icon>
            <Search />
          </el-icon>
        </template>
      </el-input>
      <el-button type="primary" style="margin-left: 5px;" @click="handleQuery()">确定</el-button>
    </el-header>
    <div class="list-wrapper">
      <div class="list">
        <el-table :data="formData" border>
          <el-table-column prop="title" label="标题" width="180px" />
          <el-table-column prop="content" label="内容" width="180" />
          <el-table-column prop="likeCount" label="点赞数" width="180" />
          <el-table-column prop="viewCount" label="观看数" width="180" />
          <el-table-column prop="createTime" label="创建时间" width="180" />
          <el-table-column prop="modifyTime" label="修改时间" width="180" />
          <el-table-column fixed="right" label="操作">
            <template #default="{ row }">
              <el-button type="primary" size="small" @click="handleEdit(row)">编辑</el-button>
              <el-button type="danger" size="small" @click="handleDel(row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>

  <!-- 编辑文章框 -->
  <div class="edit-form">

    <el-dialog v-model="dialogFormVisableEdit" title="编辑文章" width="600px">
      <el-form :data="formData" ref="formDataRef" status-icon>
        <el-form-item prop="title">
          <el-input v-model="formData.title" style="width: 240px" clearable type="text" />
          <el-input v-model="formData.content" type="textarea" style="width: 240px" clearable />
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>


</template>

<style scoped>
.list-wrapper {
  display: flex;
  height: 600px;
  width: 100%;
  margin-top: 10px;
  border: 1px solid black;
  border-radius: 1%;
  /* box-shadow: 1px 2px 5px 10px rgba(234, 231, 231); */
}

.list {
  margin: 5px;
  border: 1px solid black;
  height: 590px;
  width: 100%;
}

.header {
  border: 1px solid black;
  padding: 15px;
}
</style>
