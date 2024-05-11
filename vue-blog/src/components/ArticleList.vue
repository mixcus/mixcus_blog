<script setup>
import router from '@/router';
import { ElMessage } from 'element-plus';
import { onMounted, inject, ref } from 'vue';

import { baseURL } from '@/utils/request';

const formData = ref('')

const axios = inject("$axios")

// 生命周期函数
onMounted(() => {
  findPage();
})



// 编辑文章处理
const dialogFormVisableEdit = ref(false);
const editData = ref('');
const handleEditData = (row) => {
  //row 表格一整行的数据
  editData.value = { ...row }
}

// 编辑表单
const handleEdit = () => {
  console.log(editData.value);
  axios.post(baseURL+'/article/editArticle', editData.value).then((res) => {
    let flag = res.data.flag;
    let message = res.data.message;
    if (flag) {
      ElMessage.success(message);
      dialogFormVisableEdit.value = false;
      findPage();
    } else {
      ElMessage.error(message);
    }
  });
}


//查询文章
const queryString = ref('');
const formDataRef = ref();
//处理查询
const handleQuery = () => {
  alert(queryString.value)
}

//分页
const pagination = ref({
  currentPage: 1,  //当前页
  pageSize: 6,     //页面大小
  total: 0,        //总数
})

//获取数据
const findPage = () => {
  // const param = {
  //   queryString: queryString.value,
  //   pageSize: pagination.value.pageSize,
  //   currentPage: pagination.value.currentPage
  // }

  axios.post(baseURL+'/article/getArticleList').then((res) => {
    formData.value = res.data.data;
    pagination.value.total = res.data.totals;
  }).catch((e) => {
    console.log(e);
  })
}

const handleCurrentChange = (currentPage) => {
  pagination.value.currentPage = currentPage;
  findPage();
}
//获取数据数量

//删除数据
const handleDel = (row) => {
  let tmpData = { ...row };
  let articleId = tmpData.articleId;
  console.log(articleId);
  axios.post(baseURL+'/article/deleteArticleById', articleId).then((res) => {
    let flag = res.data.flag;
    let message = res.data.message;
    if (flag) {
      ElMessage.success(message);
      findPage();
    } else {
      ElMessage.error(message);
    }
  })
}

//跳转到添加博客页面
const handleAdd = () => {
  router.push(
    {
      path: '/',
    }
  )
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
          <el-table-column prop="title" label="标题" width="150px" />
          <el-table-column prop="content" label="内容" width="150px" />
          <el-table-column prop="tag" label="标签" width="120px" />
          <el-table-column prop="category" label="分类" width="120px" />
          <el-table-column prop="likeCount" label="点赞数" width="120px" />
          <el-table-column prop="viewCount" label="观看数" width="120px" />
          <el-table-column prop="createTime" label="创建时间" width="130px" />
          <el-table-column prop="modifyTime" label="修改时间" width="130px" />
          <el-table-column fixed="right" label="操作">
            <template #default="{ row }">
              <el-button type="primary" size="small"
                @click="dialogFormVisableEdit = true; handleEditData(row)">编辑</el-button>
              <el-button type="danger" size="small" @click="handleDel(row)">删除</el-button>
              <el-button type="success" size="small" @click="handleAdd()">添加</el-button>
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页 -->
        <div class="pagination-wrapper">
          <el-pagination background @current-change="handleCurrentChange" v-model:current-page="pagination.currentPage"
            v-model:page-size="pagination.pageSize" :total="pagination.total" layout="total, prev, pager, next, jumper">
          </el-pagination>
        </div>
      </div>
    </div>

    <!-- 编辑文章框 -->
    <div class="edit-form">

      <el-dialog v-model="dialogFormVisableEdit" title="编辑文章" width="600px">
        <el-form :data="editData" ref="formDataRef" status-icon>
          <el-form-item prop="title">
            <span>标题:</span>
            <el-input v-model="editData.title" style="width: 240px;margin-left: 10px;" clearable type="text" />
          </el-form-item>
          <el-form-item prop="content">
            <span>内容:</span>
            <el-input v-model="editData.content" type="textarea" :autosize="{ minRows: 10, maxRows: 30 }"
              style="width: 240px;margin-left: 10px;" clearable />
          </el-form-item>
          <el-form-item prop="content">
            <span>标签:</span>
            <el-input v-model="editData.tag" type="text" style="width: 240px;margin-left: 10px;" clearable />
          </el-form-item>

          <el-form-item prop="content">
            <span>分类:</span>
            <el-input v-model="editData.category" type="text" style="width: 240px;margin-left: 10px;" clearable />
          </el-form-item>

          <el-form-item>
            <div class="fotter-button">
              <el-button type="primary" @click="handleEdit()">确定</el-button>
              <el-button type="primary" @click="ElMessage.error('已取消'); dialogFormVisableEdit = false">取消</el-button>
            </div>

          </el-form-item>
        </el-form>

      </el-dialog>

    </div>
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

.edit-form {
  display: flex;
}

.fotter-button {
  margin: 50px 0px 0px 420px
}

.pagination-wrapper {
  display: flex;
  justify-content: right;
  margin: 20px 20px 0 0;
}
</style>
