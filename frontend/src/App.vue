<template>
  <div id="app" :class="{ 'dark-mode': isDarkMode, 'light-mode': !isDarkMode }">
    <nav>
      <router-link to="/">首頁</router-link> |
      <router-link to="/menu">菜單管理</router-link> |
      <router-link to="/orders">訂單管理</router-link> |
      <router-link to="/inventory">庫存管理</router-link>
      <button @click="toggleTheme">{{ isDarkMode ? '切換淺色模式' : '切換深色模式' }}</button>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      isDarkMode: true
    }
  },
  methods: {
    toggleTheme() {
      this.isDarkMode = !this.isDarkMode
    }
  }
}
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  min-height: 100vh;
  transition: background-color 0.3s, color 0.3s;
}

.dark-mode {
  background-color: rgba(6, 6, 6, 0.8);
  color: #ffffff;
}

.light-mode {
  background-color: rgba(249, 249, 249, 0.8);
  color: #000000;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: inherit;
  text-decoration: none;
  margin: 0 10px;
}

nav a.router-link-exact-active {
  color: #42b983;
}

button {
  margin-left: 20px;
  padding: 5px 10px;
  background-color: #42b983;
  color: white;
  border: none;
  cursor: pointer;
}

.input-field {
  background-color: rgba(225, 225, 225, 0.8);
  color: #000000;
  padding: 10px;
  margin: 5px 0;
  border: 1px solid #ddd;
  border-radius: 4px;
}
</style>