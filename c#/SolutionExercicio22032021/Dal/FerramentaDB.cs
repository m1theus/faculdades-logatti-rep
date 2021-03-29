using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
    public class FerramentaDB : IFerramentaDB
    {
        private readonly List<Ferramenta> lst = new List<Ferramenta>();

        public List<Ferramenta> GetAll()
        {
            return lst.ToList();
        }

        public bool Insert(Ferramenta funcionario)
        {
            lst.Add(funcionario);
            return true;
        }

        public Ferramenta SelectById(int id)
        {
            return lst.Find(x => x.Id.Equals(id));
        }

        public bool Update(Ferramenta funcionario)
        {
            var func = lst.Find(x => x.Id.Equals(funcionario.Id));

            func.Descricao = funcionario.Descricao;
            func.Tipo = funcionario.Tipo;
            func.Marca = funcionario.Marca;
            func.Preco = funcionario.Preco;
            return true;
        }

        public bool Delete(int id)
        {
            var itemToRemove = lst.Single(x => x.Id == id);
            lst.Remove(itemToRemove);
            return true;
        }
    }
}
