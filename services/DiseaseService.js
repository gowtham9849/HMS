import axios from 'axios';

const API_URL = 'http://localhost:8080/api/diseases';

class DiseaseService {
    getAllDiseases() {
        return axios.get(API_URL);
    }
}

export default new DiseaseService();
