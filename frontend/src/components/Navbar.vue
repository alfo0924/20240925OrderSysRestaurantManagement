<template>
  <nav>
    <router-link to="/">首頁</router-link> |
    <router-link to="/menu">菜單管理</router-link> |
    <router-link to="/orders">訂單管理</router-link> |
    <router-link to="/frontend/src/views/Inventory">庫存管理</router-link>
    <button @click="$emit('toggle-theme')">切換主題</button>
  </nav>
</template>

<script>
export default {
  name: 'Navbar'
}
</script>

<style scoped>
nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #ffffff;
}

nav a.router-link-exact-active {
  color: #42b983;
}

button {
  margin-left: 20px;
}
</style>