<template>
  <div class="inventory-list">
    <table>
      <thead>
      <tr>
        <th>項目名稱</th>
        <th>描述</th>
        <th>計量單位</th>
        <th>當前數量</th>
        <th>最小庫存量</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in inventoryItems" :key="item.id">
        <td>{{ item.itemName }}</td>
        <td>{{ item.itemDescription }}</td>
        <td>{{ item.unitOfMeasure }}</td>
        <td>{{ item.currentQuantity }}</td>
        <td>{{ item.minimumQuantity }}</td>
        <td>
          <button @click="editItem(item)">編輯</button>
          <button @click="$emit('delete-item', item.id)">刪除</button>
        </td>
      </tr>
      </tbody>
    </table>
    <div v-if="editingItem" class="edit-form">
      <h3>編輯庫存項目</h3>
      <form @submit.prevent="updateItem">
        <input v-model="editingItem.itemName" placeholder="項目名稱" required class="input-field">
        <input v-model="editingItem.itemDescription" placeholder="項目描述" class="input-field">
        <input v-model="editingItem.unitOfMeasure" placeholder="計量單位" required class="input-field">
        <input v-model.number="editingItem.currentQuantity" type="number" placeholder="當前數量" required class="input-field">
        <input v-model.number="editingItem.minimumQuantity" type="number" placeholder="最小庫存量" required class="input-field">
        <button type="submit">更新</button>
        <button @click="cancelEdit">取消</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'InventoryList',
  props: {
    inventoryItems: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      editingItem: null
    }
  },
  methods: {
    editItem(item) {
      this.editingItem = { ...item }
    },
    updateItem() {
      this.$emit('update-item', this.editingItem.id, this.editingItem)
      this.editingItem = null
    },
    cancelEdit() {
      this.editingItem = null
    }
  }
}
</script>

<style scoped>
.inventory-list {
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

.edit-form {
  margin-top: 20px;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

form {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.input-field {
  padding: 5px;
  font-size: 14px;
}
</style>