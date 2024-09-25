<template>
  <div class="menu-list">
    <table>
      <thead>
      <tr>
        <th>菜單名稱</th>
        <th>描述</th>
        <th>狀態</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="menu in menus" :key="menu.id">
        <td>{{ menu.menuName }}</td>
        <td>{{ menu.menuDescribe }}</td>
        <td>{{ menu.menuStatus }}</td>
        <td>
          <button @click="$emit('edit-menu', menu)">編輯</button>
          <button @click="$emit('delete-menu', menu.id)">刪除</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'MenuList',
  props: {
    menus: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
.menu-list {
  margin-top: 20px;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
  font-weight: bold;
}

button {
  margin-right: 5px;
  padding: 5px 10px;
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>