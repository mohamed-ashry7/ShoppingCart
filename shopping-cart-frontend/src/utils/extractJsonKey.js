





const extract = (obj, goal) => {
  for (let key in obj) {
    if (key === goal) {
      return obj[key];
    }
    if (typeof obj[key] === "object") {
      return extract(obj[key], goal);
    }
  }
  return []; 
};


export default extract; 
