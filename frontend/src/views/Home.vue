<template>
  <div class="home">
    <h1>餐廳管理系統</h1>
    <p>歡迎使用餐廳管理系統。請選擇以下功能：</p>
    <div class="feature-links">
      <router-link to="/menu" class="feature-link">菜單管理</router-link>
      <router-link to="/orders" class="feature-link">訂單管理</router-link>
      <router-link to="/inventory" class="feature-link">庫存管理</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home'
}
</script>

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 80vh;
}

.feature-links {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.feature-link {
  margin: 0 10px;
  padding: 10px 20px;
  background-color: #42b983;
  color: white;
  text-decoration: none;
  border-radius: 4px;
  transition: background-color 0.3s;
}

.feature-link:hover {
  background-color: #3aa876;
}
</style>