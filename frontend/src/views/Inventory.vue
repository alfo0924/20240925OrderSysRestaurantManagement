<template>
  <div class="inventory">
    <h2>庫存管理</h2>
    <InventoryList
        :inventoryItems="inventoryItems"
        @update-item="updateInventoryItem"
        @delete-item="deleteInventoryItem"
    />
    <button @click="showAddForm = true">新增庫存項目</button>
    <div v-if="showAddForm" class="add-form">
      <h3>新增庫存項目</h3>
      <form @submit.prevent="addInventoryItem">
        <input v-model="newItem.itemName" placeholder="項目名稱" required class="input-field">
        <input v-model="newItem.itemDescription" placeholder="項目描述" class="input-field">
        <input v-model="newItem.unitOfMeasure" placeholder="計量單位" required class="input-field">
        <input v-model.number="newItem.currentQuantity" type="number" placeholder="當前數量" required class="input-field">
        <input v-model.number="newItem.minimumQuantity" type="number" placeholder="最小庫存量" required class="input-field">
        <button type="submit">新增</button>
        <button @click="showAddForm = false">取消</button>
      </form>
    </div>
  </div>
</template>

<script>
import InventoryList from '@/components/InventoryList.vue'
import axios from 'axios'

export default {
  name: 'Inventory',
  components: {
    InventoryList
  },
  data() {
    return {
      inventoryItems: [],
      showAddForm: false,
      newItem: {
        itemName: '',
        itemDescription: '',
        unitOfMeasure: '',
        currentQuantity: 0,
        minimumQuantity: 0
      }
    }
  },
  methods: {
    async fetchInventoryItems() {
      try {
        const response = await axios.get('/api/inventory')
        this.inventoryItems = response.data
      } catch (error) {
        console.error('Error fetching inventory items:', error)
      }
    },
    async addInventoryItem() {
      try {
        await axios.post('/api/inventory', this.newItem)
        this.fetchInventoryItems()
        this.showAddForm = false
        this.newItem = { itemName: '', itemDescription: '', unitOfMeasure: '', currentQuantity: 0, minimumQuantity: 0 }
      } catch (error) {
        console.error('Error adding inventory item:', error)
      }
    },
    async updateInventoryItem(itemId, updatedItem) {
      try {
        await axios.put(`/api/inventory/${itemId}`, updatedItem)
        this.fetchInventoryItems()
      } catch (error) {
        console.error('Error updating inventory item:', error)
      }
    },
    async deleteInventoryItem(itemId) {
      try {
        await axios.delete(`/api/inventory/${itemId}`)
        this.fetchInventoryItems()
      } catch (error) {
        console.error('Error deleting inventory item:', error)
      }
    }
  },
  mounted() {
    this.fetchInventoryItems()
  }
}
</script>

<style scoped>
.inventory {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.add-form {
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
  padding: 10px;
  font-size: 16px;
}

button {
  padding: 10px;
  font-size: 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>